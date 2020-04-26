package com.zuniorteam.ladder.core;

import java.util.*;
import java.util.stream.IntStream;

public class Ladder {

    public static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        assert lines != null;

        if (lines.size() < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 최소 높이는 " + MIN_LADDER_HEIGHT + " 입니다. 현재 높이 : " + lines);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Map<User, String> play(List<User> users, List<String> results) {
        final Map<User, String> userToResult = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            final User user = users.get(i);
            final String result = results.get(followLadder(i));
            userToResult.put(user, result);
        }

        return userToResult;
    }

    private int followLadder(int pointIndex) {
        int nextPointIndex = pointIndex;

        for (Line line : lines) {
            nextPointIndex = getNextPointIndex(nextPointIndex, line);
        }

        return nextPointIndex;
    }

    private int getNextPointIndex(int pointIndex, Line line) {
        final int beforeBridgeIndex = pointIndex - 1;
        final int nextBridgeIndex = pointIndex;

        if (beforeBridgeIndex >= 0 && line.hasBridge(beforeBridgeIndex)) {
            return pointIndex - 1;
        }

        if (nextBridgeIndex < line.getLength() && line.hasBridge(nextBridgeIndex)) {
            return pointIndex + 1;
        }

        return pointIndex;
    }

}
