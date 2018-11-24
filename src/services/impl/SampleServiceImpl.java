/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.SampleDto;
import services.interfaces.SampleService;
import utils.DBHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shinu.k
 */
public class SampleServiceImpl implements SampleService{

    public SampleServiceImpl() {
         DBHelper.connectToDb();
    }

    
    @Override
    public void saveData(SampleDto sampleDto) {
        String query = String.format("INSERT INTO testTable (Content) values ('%s')",sampleDto.getData());
        DBHelper.updateDataToDb(query);
    }

    @Override
    public SampleDto getData(int type) {
       SampleDto dto=new SampleDto();
        ResultSet rs = null;
       String data="";
       if (type == 1) {
         rs =  DBHelper.readDataFromDb("Select * from testTable");
       } else {
          rs = DBHelper.readDataUsingSP("getContent","1");
       }
      if (rs != null) {
            try {
                while (rs.next()) {
                    String content = rs.getString("Content");
                    data +=(data.length() > 0 ? ","+content : content);
                }
                dto.setData(data);
            } catch (SQLException ex) {
                
            }
        }
       return dto;
    }
    
}
