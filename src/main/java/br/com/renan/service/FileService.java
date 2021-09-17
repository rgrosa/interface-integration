package br.com.renan.service;


import br.com.renan.dto.FileDTO;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileService {

    FileDTO getFile(String fileName) throws FileNotFoundException;

    List<String> getFileList();
}
