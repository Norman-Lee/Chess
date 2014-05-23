package org.chess.pieces;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;

import java.util.ArrayList;
import java.util.LinkedList;

public class Knight extends ChessPiece {

    public Knight(ChessSquare startPosition, Side startingSide){
        position = startPosition;
        type = "Knight";
        side = startingSide;
        position.setChessPiece(this);
    }


    @Override
    public ArrayList<ChessSquare> movableSquares(ChessSquare position){
        ArrayList<ChessSquare> squareList = new ArrayList<ChessSquare>();
        for(Direction direction: Direction.values()){
            if(direction.getType() == Direction.Type.Horizontal || direction.getType() == Direction.Type.Vertical )
                findSquares(squareList, direction, position, 0);
        }
        return squareList;
    }

    private void findSquares(ArrayList<ChessSquare> list, Direction direction, ChessSquare position, int depth){
        if(depth < 2) {
            LinkedList<ChessSquare> neighbors = position.findNeighbors(direction);
            if(neighbors != null) {
                for (int i = 0; i < neighbors.size(); i++) {
                    ChessSquare square = neighbors.get(i);
                    findSquares(list, direction, square, depth + 1);
                }
            }
        }
        else{
            LinkedList<ChessSquare> knightSquares;
                switch(direction.getType()){
                    case Vertical:
                        knightSquares = position.findNeighbors(Direction.E);
                        addPosition(list, knightSquares);
                        knightSquares = position.findNeighbors(Direction.W);
                        addPosition(list, knightSquares);

                    case Horizontal:
                        knightSquares = position.findNeighbors(Direction.N);
                        addPosition(list, knightSquares);
                        knightSquares = position.findNeighbors(Direction.S);
                        addPosition(list, knightSquares);
                }
            }
        }


    private void addPosition(ArrayList<ChessSquare> list, LinkedList<ChessSquare> spots) {
        if (spots != null) {
            for (int i = 0; i < spots.size(); i++) {
                ChessSquare spot = spots.get(i);
                if (!list.contains(spot) && spot != this.position)
                    list.add(spot);
            }
        }
    }

}
