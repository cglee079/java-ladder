package com.zuniorteam.ladder.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Line Test")
class LineTest {

    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new Line(new ArrayList<>()));
    }

    @DisplayName("생성, 실패, bridges null")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new Line(null));
    }

    @DisplayName("생성, 실패, 이어지는 bridge가 있는 경우")
    @Test
    void testNewInstance03() {
        //given
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);
        bridges.add(true);
        bridges.add(true);
        bridges.add(false);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Line(bridges));
    }

    @DisplayName("getLength()")
    @Test
    void testGetLength() {
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);
        bridges.add(false);
        bridges.add(false);

        final Line line = new Line(bridges);

        assertThat(line.getLength()).isEqualTo(bridges.size());
    }

    @DisplayName("hasBridge")
    @Test
    void testHasBridge() {
        //given
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);
        bridges.add(false);

        //when
        final Line line = new Line(bridges);

        //then
        assertThat(line.hasBridge(0)).isTrue();
        assertThat(line.hasBridge(1)).isFalse();
    }

    @DisplayName("hasBridge, index 0보다 작을 때")
    @Test
    void testHasBridgeIfLessZeroIndex() {
        //given
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);

        //when
        final Line line = new Line(bridges);

        assertThrows(IllegalArgumentException.class, () -> line.hasBridge(-1));
    }

    @DisplayName("hasLeftBridge")
    @Test
    void testHasLeftBridge() {
        //given
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);
        bridges.add(false);

        //when
        final Line line = new Line(bridges);

        //then
        assertThat(line.hasLeftBridge(0)).isFalse();
        assertThat(line.hasLeftBridge(1)).isTrue();
    }

    @DisplayName("hasRightBridge")
    @Test
    void testHasRightBridge() {
        //given
        final List<Boolean> bridges = new ArrayList<>();
        bridges.add(true);
        bridges.add(false);

        //when
        final Line line = new Line(bridges);

        //then
        assertThat(line.hasRightBridge(0)).isTrue();
        assertThat(line.hasRightBridge(1)).isFalse();
    }


}
