package org.chess.pieces.test;

import org.chess.chessboard.ChessBoard;
import org.chess.pieces.King;

import org.chess.pieces.Side;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;



public class KingTest {

    private King kingPiece;
    private ChessBoard chessBoard;

    @Before
    public void setUp() throws Exception {
        chessBoard = new ChessBoard();
        kingPiece = new King(chessBoard.findChessSquare(0), Side.White);
    }

    @Test
    public void testConstruction(){
        Assert.assertThat(kingPiece.side(), Matchers.is(Side.White));
    }

    @Test
    public void testMove()  {
        kingPiece.move(chessBoard.findChessSquare(1));
        Assert.assertThat(kingPiece.position(), Matchers.is(chessBoard.findChessSquare(1)));
    }

    @Test
    public void testGetCheckStatus() {
        Assert.assertThat(kingPiece.getCheckStatus(), CoreMatchers.is(false));
    }

    @Test
    public void testSetCheckStatus() {
        kingPiece.setCheckStatus(true);
        Assert.assertThat(kingPiece.getCheckStatus(), CoreMatchers.is(true));
    }

    @After
    public void tearDown() throws Exception {

    }
}
