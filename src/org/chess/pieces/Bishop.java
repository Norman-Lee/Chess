package org.chess.pieces;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;

import java.util.ArrayList;
import java.util.LinkedList;

public class Bishop extends ChessPiece {

    public Bishop(ChessSquare startPosition, Side startingSide){
        position = startPosition;
        type = "Bishop";
        side = startingSide;
        position.setChessPiece(this);
    }

    @Override
    public ArrayList<ChessSquare> movableSquares(ChessSquare position){
        ArrayList<ChessSquare> squareList = new ArrayList<ChessSquare>();
        for(Direction direction : Direction.values()){
            if(direction.getType() == Direction.Type.Diagonal){
                findSquares(squareList, direction, position);
            }
        }
        return squareList;
    }

    private void findSquares(ArrayList<ChessSquare> list, Direction direction, ChessSquare position){
        LinkedList<ChessSquare> neighbors = position.findNeighbors(direction);

        for(int i = 0; i <neighbors.size(); i++){
            ChessSquare square = neighbors.get(i);
            if(!list.contains(square) && square != this.position){
                list.add(square);
                findSquares(list, direction, square);
            }
        }

    }

}
