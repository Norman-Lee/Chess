package org.chess.pieces.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.Knight;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnightTest {

    private ChessSquare testSquare;
    private Knight knightTest;

    @Before
    public void setUp() throws Exception {
        testSquare = new ChessSquare("knightTest");
        knightTest = new Knight(testSquare, Side.Black);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMove(){
        ChessSquare square1 = new ChessSquare("square1");
        ChessSquare square2 = new ChessSquare("square2");
        ChessSquare square3 = new ChessSquare("square3");

        testSquare.addNeighbor(Direction.N, square1);
        square1.addNeighbor(Direction.N, square2);
        square2.addNeighbor(Direction.E, square3);

        knightTest.move(square3);
        Assert.assertThat(knightTest.position(), Matchers.is(square3));
    }

    @Test
    public void testMovableSquares(){
        ChessSquare square1 = new ChessSquare("square1");
        ChessSquare square2 = new ChessSquare("square2");
        ChessSquare square3 = new ChessSquare("square3");

        testSquare.addNeighbor(Direction.E, square1);
        square1.addNeighbor(Direction.E, square2);
        square2.addNeighbor(Direction.N, square3);

        Assert.assertThat(knightTest.movableSquares(testSquare).contains(square3), Matchers.is(true));
    }

    @Test
    public void testPosition(){
        Assert.assertThat(knightTest.position(), Matchers.is(testSquare));
    }

    @Test
    public void testName() throws Exception {
        Assert.assertThat(knightTest.name(), Matchers.is("Knight"));
    }

    @Test
    public void testSide() throws Exception {
        Assert.assertThat(knightTest.side(), Matchers.is(Side.Black));
    }
}
