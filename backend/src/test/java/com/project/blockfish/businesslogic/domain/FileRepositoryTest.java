package com.project.blockfish.businesslogic.domain;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.project.blockfish.businesslogic.domain.File;

import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRepositoryTest {

        @Autowired
        FileRepository fileRepository;

        @After
        public void cleanup() {
            fileRepository.deleteAll();
        }

        @Test
        public void 파일저장_불러오기() {
            //given
            String name = "테스트 파일";
            String imageAddress = "imageAddress";
            String fileAddress = "테스트주소";
            String info = "임시 파일 정보";
            String osType = "MAC";
            int downCount = 0;
            String blockChainAddress = "Axabcx3ctest";
            int starRank = 5;
            LocalDateTime createAt = LocalDateTime.MIN;
            LocalDateTime updateAt = LocalDateTime.MIN;
            boolean fileLock = false;

            File file = new File(name,imageAddress,fileAddress,info,osType,downCount,blockChainAddress,starRank,createAt,updateAt,fileLock);
            fileRepository.save(new File(name,imageAddress,fileAddress,info,osType,downCount,blockChainAddress,starRank,createAt,updateAt,fileLock));

/*            fileRepository.save(File.builder()
                    .name(name)
                    .imageAddress(imageAddress)
                    .fileAddress(fileAddress)
                    .info(info)
                    .osType(osType)
                    .downCount(downCount)
                    .blockChainAddress(blockChainAddress)
                    .starRank(starRank)
                    .createAt(createAt)
                    .updateAt(updateAt)
                    .fileLock(fileLock));*/

//            File newFile = fileRepository.save(file);

            //when
            List<File> fileList = fileRepository.findAll();
            //then
            File file1 = fileList.get(0);
            assertThat(file1.getName()).isEqualTo(name);
//            assertThat(newFile.getName()).isEqualTo(name);
        }
    }


