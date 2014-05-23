package org.chess.pieces.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.Bishop;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BishopTest {
    private Bishop bishopTest;
    private ChessSquare testSquare;


    @Before
    public void setUp() throws Exception{
        testSquare = new ChessSquare("bishopStart");
        bishopTest = new Bishop(testSquare, Side.Black);
    }

    @Test
    public void testMove() {
        ChessSquare diagonalSquare = new ChessSquare("Moved");
        testSquare.addNeighbor(Direction.NE, diagonalSquare);
        bishopTest.move(diagonalSquare);
        Assert.assertThat(bishopTest.position(), Matchers.is(diagonalSquare));
    }

    @Test
    public void testMovableSquares(){
        ChessSquare diagonalSquare = new ChessSquare("Hi");
        testSquare.addNeighbor(Direction.NW,diagonalSquare);
        Assert.assertThat(bishopTest.movableSquares(testSquare).contains(diagonalSquare), Matchers.is(true));
    }

    @Test
    public void testPosition(){
        Assert.assertThat(bishopTest.position(), Matchers.is(testSquare));
    }

    @Test
    public void testName(){
        Assert.assertThat(bishopTest.name(), Matchers.is("Bishop"));
    }

    @Test
    public void testSide(){
        Assert.assertThat(bishopTest.side(), Matchers.is(Side.Black));
    }

    @After
    public void tearDown() throws Exception{

    }
}
