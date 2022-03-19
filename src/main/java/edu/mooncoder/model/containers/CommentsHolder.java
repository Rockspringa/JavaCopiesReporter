package edu.mooncoder.model.containers;

import edu.mooncoder.model.wrappers.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentsHolder {
    private static CommentsHolder inst;
    private final List<Comment> comments;

    private CommentsHolder() {
        comments = new ArrayList<>();
    }

    public static void addComment(String text) {
        if (inst == null) {
            inst = new CommentsHolder();
        }
        if (text != null)
            inst.add(text);
    }

    public static List<Comment> clean() {
        if (inst == null) {
            inst = new CommentsHolder();
        }
        List<Comment> classes = inst.comments;
        inst = null;
        return classes;
    }

    public void add(String text) {
        comments.add(new Comment(text));
    }
}
