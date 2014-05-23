package org.chess.pieces;

import org.chess.chessboard.ChessSquare;
import org.chess.chessboard.Direction;

import java.util.ArrayList;
import java.util.LinkedList;

public class Pawn extends ChessPiece{

    private boolean firstMove;

    public Pawn(ChessSquare startPosition, Side startingSide){
        position = startPosition;
        type = "Pawn";
        side = startingSide;
        position.setChessPiece(this);
        firstMove = true;
    }

    @Override
    public ArrayList<ChessSquare> movableSquares(ChessSquare position){
        ArrayList<ChessSquare> squareList = new ArrayList<ChessSquare>();
        findSquares(squareList, position);
        return squareList;
    }

    private void findSquares(ArrayList<ChessSquare> list, ChessSquare position){
        if(side == Side.White){
            addSquares(list, Direction.N, position);

            if(firstMove){
                for(int i = 0; i < list.size(); i++){
                   addSquares(list,Direction.N,list.get(i));
                }
                firstMove = false;
            }
            addAttackSquares(list, Direction.NE, position);
            addAttackSquares(list, Direction.NW, position);

        }
        else if(side == Side.Black){
            addSquares(list, Direction.S, position);

            if(firstMove){
                for(int i = 0; i < list.size(); i++){
                    addSquares(list,Direction.S,list.get(i));
                }
                firstMove = false;
            }
            addAttackSquares(list, Direction.SE, position);
            addAttackSquares(list, Direction.SW, position);
        }
    }

    private void addSquares(ArrayList<ChessSquare> list, Direction direction, ChessSquare position) {
        LinkedList<ChessSquare> squares = position.findNeighbors(direction);
        for(int i = 0; i < squares.size(); i++){
            if(!squares.get(i).isFilled())
                list.add(squares.get(i));
        }
    }
    private void addAttackSquares(ArrayList<ChessSquare> list, Direction direction, ChessSquare position){

        LinkedList<ChessSquare> squares = position.findNeighbors(direction);
        for(int i = 0; i < squares.size(); i++){
            if(squares.get(i).isPlaceable(side))
                list.add(squares.get(i));
        }
    }

}
