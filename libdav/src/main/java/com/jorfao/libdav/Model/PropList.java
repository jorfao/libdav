package com.jorfao.libdav.Model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;


@Root(name="d:multistatus", strict = false)
public class PropList {
    @ElementList(entry="response", inline=true)
    public java.util.List<Prop> List = new ArrayList<>();
    public PropList(){}
}
