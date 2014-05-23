package org.chess.pieces.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.Queen;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueenTest {

    private Queen queenTest;
    private ChessSquare testSquare;

    @Before
    public void setUp() throws Exception {
        testSquare = new ChessSquare("QueenTest");
        queenTest = new Queen(testSquare, Side.White);
    }

    @Test
    public void testPosition(){
        Assert.assertThat(queenTest.position(), Matchers.is(testSquare));
    }

    @Test
    public void testName(){
        Assert.assertThat(queenTest.name(), Matchers.is("Queen"));
    }

    @Test
    public void testSide(){
        Assert.assertThat(queenTest.side(), Matchers.is(Side.White));
    }

    @Test
    public void testMove(){
        ChessSquare newSquare = new ChessSquare("Other Square");
        testSquare.addNeighbor(Direction.N, newSquare );
        queenTest.move(newSquare);
        Assert.assertThat(queenTest.position().name(), Matchers.is("Other Square"));

    }

    @After
    public void tearDown() throws Exception {

    }
}
