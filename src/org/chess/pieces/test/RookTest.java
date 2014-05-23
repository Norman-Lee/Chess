package org.chess.pieces.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.Rook;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RookTest {
    private Rook rookTest;
    private ChessSquare testSquare;

    @Before
    public void setUp() throws Exception {
        testSquare = new ChessSquare("rookTest");
        rookTest = new Rook(testSquare, Side.White);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMove() {
        ChessSquare verticalSquare = new ChessSquare("vertical");
        testSquare.addNeighbor(Direction.N, verticalSquare);
        rookTest.move(verticalSquare);
        Assert.assertThat(rookTest.position(), Matchers.is(verticalSquare));
    }

    @Test
    public void testMovableSquares() {
        ChessSquare horizontalSquare = new ChessSquare("horizontal");
        testSquare.addNeighbor(Direction.E, horizontalSquare);
        Assert.assertThat(rookTest.movableSquares(testSquare).contains(horizontalSquare), Matchers.is(true));
    }

    @Test
    public void testPosition()  {
        Assert.assertThat(rookTest.position(), Matchers.is(testSquare));
    }

    @Test
    public void testName(){
        Assert.assertThat(rookTest.name(), Matchers.is("Rook"));
    }

    @Test
    public void testSide()  {
        Assert.assertThat(rookTest.side(), Matchers.is(Side.White));
    }
}
