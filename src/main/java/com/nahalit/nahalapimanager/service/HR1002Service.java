package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.HrEmp;
import com.nahalit.nahalapimanager.repository.HrEmpRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class HR1002Service {

  private final HrEmpRepository hrEmpRepository;
  private final AuthService authService;

  public HR1002Service(HrEmpRepository hrEmpRepository, AuthService authService) {
    this.hrEmpRepository = hrEmpRepository;
    this.authService = authService;
  }
// HR EMP Service

  public List<HrEmp> getAllHrEmp() {
    return this.hrEmpRepository.findAll();
  }

  public HrEmp getHrEmp(Long empNo) throws ResourceNotFoundException {
    return this.hrEmpRepository.findById(empNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + empNo));
  }

  public HrEmp saveHrEmp(HrEmp hrEmp) throws ParseException {
    hrEmp.setSsCreatedOn(UtillDate.getDateTime());
    hrEmp.setSsModifiedOn(null);
    hrEmp.setSsCreator(authService.getUserNo());
    hrEmp.setCompanyNo(authService.getCompanyNo());
    return this.hrEmpRepository.save(hrEmp);
  }

  public List<HrEmp> saveHrEmpList(List<HrEmp> hrEmpList) {
    return this.hrEmpRepository.saveAll(hrEmpList);
  }

  public HrEmp updateHrEmp(HrEmp hrEmp) throws ResourceNotFoundException, ParseException {
    HrEmp oldData = this.hrEmpRepository.findById(hrEmp.getEmpNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + hrEmp.getEmpNo()));
    hrEmp.setSsModifiedOn(UtillDate.getDateTime());
    hrEmp.setSsCreatedOn(oldData.getSsCreatedOn());
    hrEmp.setSsModifier(authService.getUserNo());
    hrEmp.setSsCreator(oldData.getSsCreator());
    hrEmp.setCompanyNo(oldData.getCompanyNo());
    return this.hrEmpRepository.save(hrEmp);
  }

  public Map deleteHrEmp(Long empNo) {

    this.hrEmpRepository.findById(empNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + empNo));

    this.hrEmpRepository.deleteById(empNo);
    Map<String, String> deleteMessage = new HashMap<>();
    deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
    return deleteMessage;
  }
}
