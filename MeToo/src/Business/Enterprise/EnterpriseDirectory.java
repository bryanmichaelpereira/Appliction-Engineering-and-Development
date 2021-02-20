/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *

 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type,String location){
        Enterprise enterprise=null;
        if(!checkIfEntryExists(name, type.getValue(), location))
        {
            if(type==Enterprise.EnterpriseType.Intermediary){
                enterprise=new IntermediaryEnterprise(name, location);
                enterpriseList.add(enterprise);
            }
            else if(type==Enterprise.EnterpriseType.LawFirm){
                enterprise=new LawFirmEnterprise(name, location);
                enterpriseList.add(enterprise);
            }
            else if(type==Enterprise.EnterpriseType.NPO){
                enterprise=new NPOEnterprise(name, location);
                enterpriseList.add(enterprise);
            }
        }
        return enterprise;
    }
    
    public boolean checkIfEntryExists(String name, String type, String location){
        int ctr = 0;
        for(Enterprise enterprise: enterpriseList){
            if(enterprise.getEnterpriseType().getValue().equals(type)){
                if(enterprise.getName().equalsIgnoreCase(name)  && enterprise.getLocation().equalsIgnoreCase(location))
                    ctr++;
            }
        }
      return ctr>0;
    }
}
