package org.mom47.chess;


import org.fusesource.jansi.Ansi;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.mom47.chess.controller.ChessController;
import org.mom47.chess.controller.FunController;
import org.mom47.chess.model.Chess;
import org.mom47.chess.view.ChessBashView;

import java.io.IOException;

public class DemoApp {
    private Chess chess;
    private ChessBashView chessBashView;
    private FunController funController;
    private ChessController chessController;
    public DemoApp() {
        chess = new Chess();
        chessBashView = new ChessBashView(chess);
        funController = new FunController(chess, chessBashView);
        chessController = new ChessController(chess, chessBashView);
    }

    public void run() {
        chessBashView.print();
    }

    public static void main(String[] args) throws IOException {
        KeyMap map = new KeyMap();
        map.bind(ChessController.Action.Up, "\033[A");
        map.bind(ChessController.Action.Left, "\033[D");
        map.bind(ChessController.Action.Right, "\033[C");
        map.bind(ChessController.Action.Down, "\033[B");
        map.bind(ChessController.Action.Enter, "\r");
        map.bind(ChessController.Action.Escape, "\033");
        map.bind(ChessController.Action.Exit, "q");
        map.bind(ChessController.Action.Coup, "u");

        DemoApp demoApp = new DemoApp();
        if (args.length > 0) {
            if (args[0].equals("random")) {
                demoApp.funController.mixRandomlyChessPieces();
            } else if (args[0].equals("move")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                demoApp.funController.move(file, rank);
            } else if (args[0].equals("snake")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                int mix = Integer.valueOf(args[3]);
                demoApp.funController.moveSnake(file, rank, mix);
            } else if (args[0].equals("massacre")) {
                int mix = Integer.valueOf(args[1]);
                demoApp.funController.massacre(mix);
            } else if (args[0].equals("tag")) {
                int mix = Integer.valueOf(args[1]);
                demoApp.funController.tag(mix);
            } else if (args[0].equals("crazy-wander")) {
                int file = Integer.valueOf(args[1]);
                int rank = Integer.valueOf(args[2]);
                int hidePiece = Integer.valueOf(args[3]);
                demoApp.funController.crazyWander(file, rank, hidePiece);
            }
            demoApp.run();
        }
    }
}
