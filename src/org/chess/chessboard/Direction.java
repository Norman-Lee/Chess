package org.chess.chessboard;

public enum Direction {
    N (Type.Vertical), S(Type.Vertical),
    W(Type.Horizontal), E(Type.Horizontal),
    NE(Type.Diagonal), NW(Type.Diagonal), SE(Type.Diagonal), SW(Type.Diagonal);

    public enum Type{
        Vertical, Horizontal, Diagonal;
    }

    private Type type;

    private Direction(Type type){
        this.type = type;
    }

    public Type getType(){
        return type;
    }
}
