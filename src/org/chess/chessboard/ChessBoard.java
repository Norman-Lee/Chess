package org.chess.chessboard;

import java.util.ArrayList;
import java.util.HashMap;

public class ChessBoard {

    private ArrayList<ChessSquare> board;
    private HashMap<String, Integer> nameToIndex;


    public ChessBoard(){
        board = new ArrayList<ChessSquare>();
        nameToIndex = new HashMap<String, Integer>();

        this.loadBoard();
        this.connectBoard();

    }

    private void loadBoard(){
        char [] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        for(int i = 0; i < 8; i++){
            for(int j = 1; j <=8; j++){

                String name = String.valueOf(letters[i]) + String.valueOf(j);
                ChessSquare cs = new ChessSquare(name);
                board.add(cs);

                nameToIndex.put(name,Integer.valueOf(i*8 + j - 1));

            }
        }
    }

    private void connectBoard(){
        for(int k = 0; k <board.size(); k++){

            char[] name = board.get(k).name().toCharArray();

            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++ ){


                    if(!( (char)(name[0] + i) < 'A' || (char)(name[0] + i) > 'H' || (char)(name[1] + j) < '1' || (char)(name[1] + j) > '8' || (i == 0 && j ==0))){

                        String neighborName = String.valueOf((char)(name[0] +i)) + String.valueOf((char)(name[1] + j));

                        //Initialize directions
                        if(i == -1 && j == -1)
                            board.get(k).addNeighbor(Direction.SW, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == 1 && j == 1)
                            board.get(k).addNeighbor(Direction.NE, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == -1 && j == 1)
                            board.get(k).addNeighbor(Direction.NW, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == 1 && j == -1)
                            board.get(k).addNeighbor(Direction.SE, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == 0 && j == -1)
                            board.get(k).addNeighbor(Direction.S, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == 0 && j == 1)
                            board.get(k).addNeighbor(Direction.N, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == -1 && j == 0)
                            board.get(k).addNeighbor(Direction.E, board.get(nameToIndex.get(neighborName).intValue()));
                        else if(i == 1 && j ==0)
                            board.get(k).addNeighbor(Direction.W, board.get(nameToIndex.get(neighborName).intValue()));


                    }
                }
            }

        }
    }

    public boolean isEmpty(){
        return board.isEmpty();
    }

    public int size(){
        return board.size();
    }

    public ChessSquare findChessSquare(int index){
        return board.get(index);
    }


}
