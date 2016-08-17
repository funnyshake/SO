package com.pineone.icbms.so.contextmodel;

import com.pineone.icbms.so.contextinformation.entity.ContextInformation;
import com.pineone.icbms.so.contextinformation.store.ContextInformationMapStore;
import com.pineone.icbms.so.contextinformation.store.ContextInformationStore;
import com.pineone.icbms.so.contextmodel.entity.ContextModel;
import com.pineone.icbms.so.contextmodel.entity.Domain;
import com.pineone.icbms.so.contextmodel.logic.ContextModelLogicImpl;
import com.pineone.icbms.so.contextmodel.pr.ContextModelPresentation;
import com.pineone.icbms.so.contextmodel.ref.ResponseMessage;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melvin on 2016. 8. 16..
 * NOTE: 응급상황 발생 테스트
 */
public class ContextModelExecuteTest {

    ContextModelPresentation contextModelPresentation = new ContextModelPresentation();

    @Before
    public void setData() {
        ContextModel contextModel = new ContextModel();

        //NOTE: 도메인 셋팅
        Domain domain1 = new Domain("강의실", "http://강의실");
        Domain domain2 = new Domain("기숙사", "http://기숙사");
        List<Domain> domainList = new ArrayList<>();
        domainList.add(domain1);
        domainList.add(domain2);

        //NOTE : CI 셋팅
        ContextInformation contextInformation1 = new ContextInformation();
        ContextInformation contextInformation2 = new ContextInformation();
        contextInformation1.setName("고온상황");
        contextInformation2.setName("사람없음");
        List<String> contextInformationNameList = new ArrayList<>();
        contextInformationNameList.add(contextInformation1.getName());
        contextInformationNameList.add(contextInformation2.getName());

        contextModel.setDomainList(domainList);
        contextModel.setContextInformationList(contextInformationNameList);
        contextModel.setName("화재상황");
        contextModel.setContextType("Emergency");

        contextModelPresentation.registerGeneralContextController(contextModel);
    }


    @Test
    public void emergencyTest() throws Exception {

        ContextModel contextModel = contextModelPresentation.retrieveContextModelDetailController("화재상황");
        ResponseMessage responseMessage = contextModelPresentation.emergencyContextModel(contextModel);
        System.out.println(responseMessage.getMessage());
//        if (!(ContextModelLogicImpl.CONTEXT_MODEL_QUEUE.isEmpty())) {
//            ContextModel contextModel1 = (ContextModel) ContextModelLogicImpl.CONTEXT_MODEL_QUEUE.peek();
//            System.out.println(contextModel1.getName());
//        }

    }

//    public static void main(String[] args) {
//        ContextModel contextModel = new ContextModel();
//        ContextModelPresentation contextModelPresentation = new ContextModelPresentation();
//
//        //NOTE: 도메인 셋팅
//        Domain domain1 = new Domain("강의실", "http://강의실");
//        Domain domain2 = new Domain("기숙사", "http://기숙사");
//        List<Domain> domainList = new ArrayList<>();
//        domainList.add(domain1);
//        domainList.add(domain2);
//
//        //NOTE : CI 셋팅
//        ContextInformation contextInformation1 = new ContextInformation();
//        ContextInformation contextInformation2 = new ContextInformation();
//        contextInformation1.setName("고온상황");
//        contextInformation2.setName("사람없음");
//        List<String> contextInformationNameList = new ArrayList<>();
//        contextInformationNameList.add(contextInformation1.getName());
//        contextInformationNameList.add(contextInformation2.getName());
//
//        contextModel.setDomainList(domainList);
//        contextModel.setContextInformationList(contextInformationNameList);
//        contextModel.setName("화재상황");
//        contextModel.setContextType("Emergency");
//
//        contextModelPresentation.registerGeneralContextController(contextModel);
//        ContextModel contextModel1 = contextModelPresentation.retrieveContextModelDetailController("화재상황");
//        ResponseMessage responseMessage = contextModelPresentation.emergencyContextModel(contextModel1);
//        System.out.println(responseMessage.getMessage());
//    }
}