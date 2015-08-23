package com.github.maximenajim;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReactMicroBenchmark {

    static final int NUM_COMMENTS = 10;
    static Invocable nashornScriptEngine = (Invocable) setupNashornScriptEngine();
    static List<Comment> comments = generateComments(NUM_COMMENTS);

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ReactMicroBenchmark.class.getSimpleName())
                .warmupIterations(20)
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public String microbenchmark() {
        try {
            Object html = nashornScriptEngine.invokeFunction("renderServer", comments);
            return String.valueOf(html);
        } catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }

    private static Reader read(String path) {
        InputStream in = ReactMicroBenchmark.class.getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }

    private static List<Comment> generateComments(int NUM_COMMENTS) {
        Random random = new Random();
        List<Comment> comments = new ArrayList<Comment>();
        for (int j = 0; j < NUM_COMMENTS; ++j) {
            comments.add(new Comment("Name " + random.nextInt(), "This is comment #" + random.nextInt() + "."));
        }
        return comments;
    }

    private static ScriptEngine setupNashornScriptEngine() throws RuntimeException {
        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine("--optimistic-types=true");
        try {
            engine.eval(read("nashorn-polyfill.js"));
            engine.eval(read("react.js"));
            engine.eval(read("commentBox.js"));
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        return engine;
    }

    public static class Comment {
        private String author;
        private String text;

        public Comment(String author, String text) {
            this.author = author;
            this.text = text;
        }

        public String getAuthor() {
            return author;
        }

        public String getText() {
            return text;
        }
    }

}