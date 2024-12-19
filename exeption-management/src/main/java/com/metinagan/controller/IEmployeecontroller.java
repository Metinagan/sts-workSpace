package com.metinagan.controller;

import com.metinagan.dto.DtoEmployee;
import com.metinagan.model.RootEntity;

public interface IEmployeecontroller {

	public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
