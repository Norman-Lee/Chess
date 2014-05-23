package org.chess.chessboard;

import org.chess.pieces.ChessPiece;
import org.chess.pieces.Side;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ChessSquare{

    private String name;
    private HashMap<Direction, LinkedList<ChessSquare>> neighbors;
    private ChessPiece piece = null;

    //Need to change this if multiple sides are present, become more robust code
    //Also need to do it for basic black and white
    private int safe;

    static private ArrayList<ChessPiece> deadPieces;


    public ChessSquare(){
        deadPieces = new ArrayList<ChessPiece>();
        safe = 0;
        neighbors =  new HashMap<Direction, LinkedList<ChessSquare>>();
        for(Direction direction : Direction.values()){
            LinkedList<ChessSquare> newList = new LinkedList<ChessSquare>();
            neighbors.put(direction, newList);
        }

    }

    public ChessSquare(String newname){
        name = newname;
        deadPieces = new ArrayList<ChessPiece>();
        safe = 0;
        neighbors = new HashMap<Direction, LinkedList<ChessSquare>>();

        for(Direction direction : Direction.values()){
            LinkedList<ChessSquare> newList = new LinkedList<ChessSquare>();
            neighbors.put(direction, newList);
        }
    }

    public String name(){
        //Need to handle the empty case
        return name;
    }

    public int numEdges(){
        int numEdges =0;
        for(int i = 0; i < neighbors.size(); i++){
            if(neighbors.get(i) != null)
                numEdges += neighbors.get(i).size();
        }
        return numEdges;
    }

    public void setChessPiece(ChessPiece newPiece){
        piece = newPiece;
    }

    public void removeChessPiece(){
        piece = null;
    }

    public LinkedList<ChessSquare> findNeighbors(Direction direction){
        if(neighbors.get(direction) != null)
            return neighbors.get(direction);
        else {
            LinkedList<ChessSquare> empty = new LinkedList<ChessSquare>();
            return empty;
        }
    }

    public void decreaseDanger(){
        if(safe > 0)
            safe--;
    }

    public void increaseDanger(){
        safe++;
    }

    public boolean isSafe(){
        if(safe == 0)
            return true;
        else
            return false;
    }

    public boolean isPlaceable(Side side){
        if(piece == null)
            return true;
        else if(piece.side() != side){
            return true;
        }
        else
            return false;
    }

    public boolean isFilled(){
        if(piece == null)
            return false;
        else
            return true;
    }

    public void killPiece(){
        deadPieces.add(piece);
        piece = null;
    }

    public void addNeighbor(Direction direction, ChessSquare square){
        if(square != null) {
            neighbors.get(direction).push(square);
        }
        else{
            System.out.println("Cannot add nonexistent square");
        }
    }
}

