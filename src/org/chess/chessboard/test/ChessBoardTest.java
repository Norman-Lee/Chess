package org.chess.chessboard.test;

import org.hamcrest.Matchers;
import org.chess.chessboard.ChessBoard;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends ChessBoard {

    private ChessBoard boardTest;

    @Before
    public void setUp() throws Exception {
        boardTest = new ChessBoard();
    }
/*
    @Test
    public void testChessBoardFactory(){
        ChessBoard factoryTest = ChessBoardFactory.buildBoard("Normal");
        Assert.assertThat(factoryTest, Matchers.instanceOf(NormalChessBoard.class));

    }
*/
    @Test
    public void testIsChessBoardEmpty(){
        Assert.assertThat(boardTest.isEmpty(), Matchers.is(false));
    }

    @Test
    public void testIsChessBoardFull(){
        Assert.assertThat(boardTest.size(), Matchers.is(64));
    }


    @After
    public void tearDown() throws Exception {

    }
}
