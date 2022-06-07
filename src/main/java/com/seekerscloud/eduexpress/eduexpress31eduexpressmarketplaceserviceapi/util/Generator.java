package com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.util;



import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.dto.returnDTO.GeneratedIdentificationDTO;
import com.seekerscloud.eduexpress.eduexpress31eduexpressmarketplaceserviceapi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {
    @Autowired
    private ProductRepo productRepo;





    private final Random RANDOM = new Random();
    private final String NUMERIC = "0123456789";
    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Long generateDigits(int length) {
        return generateRandomDigits(length);
    }

    private Long generateRandomDigits(int length) {
        StringBuilder returnValue = new StringBuilder(length);


        for (int i = 0; i < length; i++) {
            returnValue.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }
        return Long.parseLong(returnValue.toString());
    }

    public GeneratedIdentificationDTO createId() {
        StringBuilder sb = new StringBuilder(4);
       // do {
            //remove spaces & toUppercase
            int randomNumber = new Random().nextInt(8 - 1) + 1;
            for (int i = 0; i < randomNumber; i++) {
                // generate a random number between
                int index = (int) (ALPHABET.length() * Math.random());
                // add Character one by one in end of sb
                sb.append(ALPHABET.charAt(index));
            }

        //} while (teacherService.existsByPrefix(sb.toString()));
        Long digits = generateDigits(11);
        //sb.append("-T");
        return new GeneratedIdentificationDTO(digits, sb.toString());
    }
//
//    public GeneratedIdentificationDTO createSystemUserId() {
//        StringBuilder sb = new StringBuilder(4);
////        do {
//            //remove spaces & toUppercase
//            int randomNumber = new Random().nextInt(8 - 1) + 1;
//            for (int i = 0; i < randomNumber; i++) {
//                // generate a random number between
//                int index = (int) (ALPHABET.length() * Math.random());
//                // add Character one by one in end of sb
//                sb.append(ALPHABET.charAt(index));
//            }
//
////        } while (teacherService.existsByPrefix(sb.toString()));
//        Long digits = generateDigits(11);
//        sb.append("-SU");
//        return new GeneratedIdentificationDTO(digits,sb.toString());
//    }
//
//    public String CreateStudentIdConvention(String prefix) {
//        String lastId = studentIdConventionRepo.findLastId(prefix+"-SIC-",prefix.length()+6);
//        if (lastId == null) {
//            return prefix + "-SIC-1";
//        }
//        int i = (Integer.parseInt(lastId.split(prefix + "-SIC-")[1]))+1;
//        System.out.println(i);
//        return prefix + "-SIC-" + i;
//    }

//    public String createUserId(String prefix) {
//        String lastId = userRepo.findLastId(prefix+"-SY-",prefix.length()+5);
//        if (lastId == null) {
//            return prefix + "-SY-1";
//        }
//
//        int i = (Integer.parseInt(lastId.split(prefix + "-SY-")[1]))+1;
//        System.out.println(i);
//        return prefix + "-SY-" + i;
//    }
//    public String createTeacherId(String prefix) {
//        String lastId = repo1.findLastId(prefix+"-TSU-",prefix.length()+4);
//        if (lastId == null) {
//            return prefix + "-TSU-1";
//        }
//
//        int i = (Integer.parseInt(lastId.split(prefix + "-TSU-")[1]))+1;
//        System.out.println(i);
//        return prefix + "-TSU-" + i;
//    }
//    public String createBusinessDepartmentId(String prefix) {
//        String lastId = branchRepo.findLastId(prefix+"-RBD-",prefix.length()+4);
//        if (lastId == null) {
//            return prefix + "-RBD-1";
//        }
//
//        int i = (Integer.parseInt(lastId.split(prefix + "-RBD-")[1]))+1;
//        System.out.println(i);
//        return prefix + "-RBD-" + i;
//    }
public String createProductId(String prefix) {
    String lastId = productRepo.findLastId(prefix+"-EEMPP-",prefix.length()+8);
    if (lastId == null) {
        return prefix + "-EEMPP-1";
    }

    int i = (Integer.parseInt(lastId.split(prefix + "-EEMPP-")[1]))+1;
    System.out.println(i);
    return prefix + "-EEMPP-" + i;
}
    public String createProductIdHotDeal(String prefix) {
        String lastId = productRepo.findLastId(prefix+"-EMPHDA-",prefix.length()+7);
        if (lastId == null) {
            return prefix + "-EMPHDA-1";
        }

        int i = (Integer.parseInt(lastId.split(prefix + "-EMPHDA-")[1]))+1;
        System.out.println(i);
        return prefix + "-EMPHDA-" + i;
    }




    public String createProductReview(String userId) {
        String lastId = productRepo.findLastId(userId+"-MPPR-",userId.length()+4);
        if (lastId == null) {
            return userId + "-MPPR-1";
        }

        int i = (Integer.parseInt(lastId.split(userId + "-MPPR-")[1]))+1;
        System.out.println(i);
        return userId + "-MPPR-" + i;
    }


}
