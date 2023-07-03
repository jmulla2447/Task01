package com.okapi.org.model.entity;

public enum CMDTYPE {
    ADD("add"), FETCH_DIA("fd"), FETCH_ORTHO("fo"), NONE("Command not identified");

    private final String info;

    CMDTYPE(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static CMDTYPE getCommandType(String info){
        for(CMDTYPE cmdtype: CMDTYPE.values()){
            if(info.equals(cmdtype.getInfo())){
                return cmdtype;
            }
        }
        return NONE;
    }

}
