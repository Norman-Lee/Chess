package org.chess.pieces.test;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;
import org.chess.pieces.Pawn;
import org.chess.pieces.Side;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PawnTest {
    private ChessSquare testSquare;
    private Pawn pawnTest;

    @Before
    public void setUp() throws Exception {
        testSquare = new ChessSquare();
        pawnTest = new Pawn(testSquare, Side.White);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMove(){
        ChessSquare moveSquare = new ChessSquare("Moved");
        testSquare.addNeighbor(Direction.N, moveSquare);
        pawnTest.move(moveSquare);
        Assert.assertThat(pawnTest.position(), Matchers.is(moveSquare));
    }

    @Test
    public void testMovableSquares() {
        ChessSquare startSquare = new ChessSquare("firstMove");
        ChessSquare attackSquare1 = new ChessSquare("attack1");
        ChessSquare attackSquare2 = new ChessSquare("attack2");
        ChessSquare normalMove = new ChessSquare("normalMove");

        testSquare.addNeighbor(Direction.N,normalMove);
        testSquare.addNeighbor(Direction.NE,attackSquare1);
        testSquare.addNeighbor(Direction.NW,attackSquare2);
        normalMove.addNeighbor(Direction.N, startSquare);

        Assert.assertThat(pawnTest.movableSquares(testSquare).size(), Matchers.is(4));

    }

    @Test
    public void testAttack(){
        ChessSquare attackSquare = new ChessSquare("Attack");
        testSquare.addNeighbor(Direction.NE, attackSquare);
        pawnTest.move(attackSquare);
        Assert.assertThat(pawnTest.position(), Matchers.is(attackSquare));
    }

    @Test
    public void testPosition() {
        Assert.assertThat(pawnTest.position(), Matchers.is(testSquare));
    }

    @Test
    public void testName() {
        Assert.assertThat(pawnTest.name(),Matchers.is("Pawn"));
    }


    @Test
    public void testSide() {
        Assert.assertThat(pawnTest.side(), Matchers.is(Side.White));
    }
}
