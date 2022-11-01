package com.springboot.hello.parser;

import com.springboot.hello.domain.Hospital;

import java.time.LocalDateTime;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String str) {
        String[] row = str.split("\",\"");
        Hospital hospital = new Hospital();


        //1, Id()); // col:0
//"의원", OpenServiceName());//col:1
//3620000,OpenLocalGovernmentCode()); // col: 3
//"PHMA119993620020041100004",ManagementNumber()); // col:4
//LocalDateTime.of(1999, 6, 12, 0, 0, 0), LicenseDate()); //19990612 //col:5
//1, BusinessStatus()); //col:7
//13, BusinessStatusCode());//col:9
//"062-515-2875", Phone());//col:15
//"광주광역시 북구 풍향동 565번지 4호 3층", FullAddress()); col:18
//"광주광역시 북구 동문대로 24, 3층 (풍향동)", RoadNameAddress());//col:19
//"효치과의원", HospitalName());//col:21
//"치과의원", BusinessTypeName());//col:25
//1, HealthcareProviderCount()); //col:29
//0, PatientRoomCount()); //col:30
//0, TotalNumberOfBeds()); //col:31
//52.29, TotalAreaSize()); //col:32


        //1 .id = 첫번쨰 " 따로처리
        hospital.setId(Integer.parseInt(row[0].replace("\"",""))); // StoI
        //2. 서비스명
        hospital.setOpenServiceName(row[1]);
        //3. 개방자치단체코드
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[3]));
        //4. 관리번호
        hospital.setManagementNumber(row[4]);
        //5. 인허가일자
        int year = Integer.parseInt(row[5].substring(0,4));
        int month = Integer.parseInt(row[5].substring(4,6));
        int day = Integer.parseInt(row[5].substring(6,8));
//        System.out.printf("%d %d %d \n", year, month, day);
        hospital.setLicenseData(LocalDateTime.of(year,month,day,0,0,0)); //날짜 로직 처리해야함
        //6. 영업상태구분코드
        hospital.setBusinessStatus(Integer.parseInt(row[7]));
        //7. 상세영업상태코드
        hospital.setBusinessStatusCode(Integer.parseInt(row[9]));
        //8. 소재지 전화
        hospital.setPhone(row[15]);
        //9. 소재지 전체주소
        hospital.setFullAddress(row[18]);
        //10. 소재지 도로명주소
        hospital.setRoadNameAddress(row[19]);
        //11. 사업자명
        hospital.setHospitalName(row[21]);
        //12. 업태구분명 ex)치과의원, 한의원
        hospital.setBusinessTypeName(row[25]);
        //13. 입원실 수
        hospital.setHealthcareProviderCount(Integer.parseInt(row[29]));
        //15. 병상 수
        hospital.setPatientRoomCount(Integer.parseInt(row[30]));
        //14. 병상 수
        hospital.setTotalNumberOfBeds(Integer.parseInt(row[31]));
        //15. 총 면적
        hospital.setTotalAreaSize(Float.parseFloat(row[32]));
        return hospital;
    }
}
