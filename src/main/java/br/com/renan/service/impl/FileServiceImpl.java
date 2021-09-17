package br.com.renan.service.impl;

import br.com.renan.service.FileService;
import br.com.renan.dto.FileDTO;
import br.com.renan.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {


    @Value("${file.system.path}")
    private String fileSystemPath;


    @Override
    public FileDTO getFile(String fileName) throws FileNotFoundException {
        String pathName = getFilePath(fileName);
        FileDTO fileDto = new FileDTO();
        if(!(new File(pathName).isFile())){
            fileDto.setStatus("Erro arquivo não existe");
            fileDto.setFileName(null);
            fileDto.setContent(null);
            return fileDto;
        }
        File file = new File(pathName);
        fileDto.setStatus("Arquvio Existe :)");
        fileDto.setFileName(file.getName());
        fileDto.setContent(FileUtil.readFile(file));
        return fileDto;
    }

    @Override
    public List<String> getFileList() {
        File[] files = new File(fileSystemPath).listFiles();
        List<String> results = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return  results;
    }

    private String getFilePath(String fileName) {
        StringBuilder  filePath = new StringBuilder();
        String normalizedFileName = fileName.toLowerCase().replaceAll(".txt", "");
        return filePath.append(this.fileSystemPath).append("/").append(normalizedFileName).append(".txt").toString();
    }



}
