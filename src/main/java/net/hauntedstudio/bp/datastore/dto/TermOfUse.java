package net.hauntedstudio.bp.datastore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TermOfUse {
    private int id;
    private int term_id;
    private int type;
    private int revision;
    private int platform;
    private String lang;
    private String title;
    private String desc;
    private String content;
    private int sort_id;}

