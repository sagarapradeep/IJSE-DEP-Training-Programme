package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        this.pieces = new Piece[NUM_OF_COLS][NUM_OF_RAWS];

        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_RAWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }


    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        for (int i = 0; i < NUM_OF_RAWS; i++) {
            if (pieces[col][i] == Piece.EMPTY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        return findNextAvailableSpot(col) != -1;
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (isLegalMove(i)) return true;
        }
        return false;
    }

    @Override
    public void updateMove(int col, int raw,Piece move) {
        pieces[col][findNextAvailableSpot(col)] = move;

    }

    @Override
    public Winner findWinner() {
        /*check columns*/
        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < 2; j++) {
                if (pieces[i][j] == Piece.GREEN &&
                        pieces[i][j + 1] == Piece.GREEN
                        && pieces[i][j + 2] == Piece.GREEN &&
                        pieces[i][j + 3] == Piece.GREEN) {

                    return new Winner(Piece.GREEN, i, j, i, j + 3);


                } else if (pieces[i][j] == Piece.BLUE &&
                        pieces[i][j + 1] == Piece.BLUE
                        && pieces[i][j + 2] == Piece.BLUE &&
                        pieces[i][j + 3] == Piece.BLUE) {
                    return new Winner(Piece.BLUE, i, j, i, j + 3);
                }
            }
        }
        /*check rows*/
        for (int i = 0; i < NUM_OF_RAWS; i++) {
            for (int j = 0; j < 3; j++) {
                if (pieces[j][i] == Piece.GREEN &&
                        pieces[j + 1][i] == Piece.GREEN
                        && pieces[j + 2][i] == Piece.GREEN &&
                        pieces[j + 3][i] == Piece.GREEN) {

                    return new Winner(Piece.GREEN, j, i, j + 3, i);


                } else if (pieces[j][i] == Piece.BLUE &&
                        pieces[j+1][i] == Piece.BLUE
                        && pieces[j+2][i] == Piece.BLUE &&
                        pieces[j+3][i] == Piece.BLUE) {
                    return new Winner(Piece.BLUE, j, i, j + 3, i);
                }


            }

        }

//        return null;
        return new Winner(Piece.EMPTY);
    }
}
