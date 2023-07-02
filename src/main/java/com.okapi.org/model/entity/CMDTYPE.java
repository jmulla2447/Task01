package com.okapi.org.model.entity;

public enum CMDTYPE {
    ADD("add"), FETCH("fetch"), NONE("");

    private final String info;

    CMDTYPE(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public CMDTYPE getCommandType(String info){
        for(CMDTYPE cmdtype: CMDTYPE.values()){
            if(info.equals(cmdtype.getInfo())){
                return cmdtype;
            }
        }
        return NONE;
    }

}
