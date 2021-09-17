package br.com.renan.controller;


import br.com.renan.dto.FileDTO;
import br.com.renan.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @CrossOrigin
    @GetMapping("/file")
    @ResponseBody
    public ResponseEntity<FileDTO> getFile(@Valid @RequestParam String fileName) throws Exception {
        return ResponseEntity.ok().body(fileService.getFile(fileName));
    }

    @CrossOrigin
    @GetMapping("/file/list")
    @ResponseBody
    public ResponseEntity<List<String>> getFileList() throws Exception {
        return ResponseEntity.ok().body(fileService.getFileList());
    }
}
