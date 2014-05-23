package org.chess.pieces;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;

import java.util.ArrayList;
import java.util.LinkedList;

public class Queen extends ChessPiece {

    public Queen(ChessSquare startPosition, Side startingSide){
        position = startPosition;
        type = "Queen";
        side = startingSide;
        position.setChessPiece(this);
    }


    @Override
    public ArrayList<ChessSquare> movableSquares (ChessSquare position){
        ArrayList<ChessSquare> squareList = new ArrayList<ChessSquare>();

        for(Direction direction : Direction.values())
            findSquares(squareList, direction, position);

        return squareList;
    }

    private void findSquares(ArrayList<ChessSquare> squareList, Direction direction, ChessSquare position){

        LinkedList<ChessSquare> neighbors = position.findNeighbors(direction);

        for(int i = 0; i <neighbors.size(); i++ ){
            ChessSquare square  = neighbors.get(i);
            if(!squareList.contains(square) && square != this.position){
                squareList.add(square);
                findSquares(squareList, direction, square);
            }
        }
    }

}
