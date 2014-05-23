package org.chess.pieces;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;

import java.util.ArrayList;


public class King extends ChessPiece{

    private boolean inCheck;

    public King(ChessSquare startPosition, Side startingSide){
        position = startPosition;
        inCheck = false;
        type = "King";
        side = startingSide;
        position.setChessPiece(this);
    }


    @Override
    public void move(ChessSquare newPosition) {

        if(newPosition.isSafe())
            super.move(newPosition);
        else
            System.out.println("Will put the King into check");

    }

    @Override
    public ArrayList<ChessSquare> movableSquares(ChessSquare position){
        ArrayList<ChessSquare> squareList = new ArrayList<ChessSquare>();

        for(Direction direction : Direction.values()){
            for(int i = 0; i < position.findNeighbors(direction).size(); i++)
            squareList.add(position.findNeighbors(direction).get(i));
        }

        return squareList;
    }

    public boolean getCheckStatus(){
        return inCheck;
    }

    public void setCheckStatus(boolean check){
        inCheck = check;
    }


}
