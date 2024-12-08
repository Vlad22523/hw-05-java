package com.example;

public class FiniteAutomaton {


    public static final int STATE_INITIAL = 0;
    public static final int STATE_T = 1;
    public static final int STATE_TE = 2;
    public static final int STATE_TES = 3;
    public static final int STATE_FINAL = 4;

    public int processString(String input) {
        int currentState = STATE_INITIAL;

        for (char c : input.toCharArray()) {
            currentState = transition(currentState, c);

            if (currentState == STATE_FINAL) {
                break;
            }
        }

        return currentState;
    }

    private int transition(int currentState, char inputChar) {
        switch (currentState) {
            case STATE_INITIAL:
                return inputChar == 'T' ? STATE_T : STATE_INITIAL;
            case STATE_T:
                return inputChar == 'E' ? STATE_TE : (inputChar == 'T' ? STATE_T : STATE_INITIAL);
            case STATE_TE:
                return inputChar == 'S' ? STATE_TES : (inputChar == 'T' ? STATE_T : STATE_INITIAL);
            case STATE_TES:
                return inputChar == 'T' ? STATE_FINAL : STATE_INITIAL;
            case STATE_FINAL:
                return STATE_FINAL;
            default:
                return STATE_INITIAL;
        }
    }
}