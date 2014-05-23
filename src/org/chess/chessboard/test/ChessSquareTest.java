package org.chess.chessboard.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.King;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ChessSquareTest {
    private ChessSquare squareTest;
    @Before
    public void setUp() throws Exception {
        squareTest = new ChessSquare("New Square");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testName() {
        Assert.assertThat(squareTest.name(), Matchers.is("New Square"));
    }

    @Test
    public void testNumEdges()  {
        Assert.assertThat(squareTest.numEdges(), Matchers.is(0));
    }

    @Test
    public void testSetChessPiece()  {
        King king = new King(squareTest, Side.White);
        squareTest.setChessPiece(king);
        Assert.assertThat(squareTest.isFilled(), Matchers.is(true));
    }

    @Test
    public void testKillPiece(){
        King king = new King(squareTest, Side.White);
        squareTest.killPiece();
        Assert.assertThat(squareTest.isFilled(), Matchers.is(false));
    }


    @Test
    public void testRemoveChessPiece()  {
        King king = new King(squareTest, Side.White);
        squareTest.removeChessPiece();
        Assert.assertThat(squareTest.isFilled(), Matchers.is(false));
    }

    @Test
    public void testFindNeighbors() {
        Assert.assertThat(squareTest.findNeighbors(Direction.N).size(), Matchers.is(0));
    }


    @Test
    public void testIsSafe() throws Exception {

    }
}
