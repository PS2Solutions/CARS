/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.SampleDto;

/**
 *
 * @author shinu.k
 */
public interface SampleService {
    public void saveData(SampleDto sampleDto);
    public SampleDto getData(int type);
}
