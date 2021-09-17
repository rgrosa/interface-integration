package br.com.renan.dto;

public class FileDTO {

    String status;
    String fileName;
    String content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "status='" + status + '\'' +
                ", fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
