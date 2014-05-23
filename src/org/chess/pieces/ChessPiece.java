package org.chess.pieces;

import org.chess.chessboard.ChessSquare;

import java.util.ArrayList;

abstract public class ChessPiece {

    String type;
    ChessSquare position;
    Side side;

    public void move(ChessSquare newPosition){
        ArrayList<ChessSquare> availableSpaces = movableSquares(position);
        if(availableSpaces.contains(newPosition) && newPosition.isPlaceable(side)){
            decreaseDanger(availableSpaces);
            position.removeChessPiece();
            if(newPosition.isFilled())
                newPosition.killPiece();
            position = newPosition;
            newPosition.setChessPiece(this);
            increaseDanger(movableSquares(newPosition));
        }
    }
    public abstract ArrayList<ChessSquare> movableSquares(ChessSquare position);
    public ChessSquare position(){return position;}
    public String name(){
        return type;
    }
    public Side side(){return side;}

    private void increaseDanger(ArrayList<ChessSquare> spaces){
        for(int i = 0; i < spaces.size(); i++)
            spaces.get(i).increaseDanger();
    }

    private void decreaseDanger(ArrayList<ChessSquare> spaces){
        for(int i = 0; i < spaces.size(); i++)
            spaces.get(i).decreaseDanger();
    }

}
