package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.repository.FileRepository;


@Service
public class FileStrorageService {
	
	@Autowired
	FileRepository FR;
	
	
		
		public FileDB store(MultipartFile file) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

		    return FR.save(FileDB);
		  }
		
		public FileDB getFile(int id) {
		    return FR.findById(id).get();
		  }
		  
		  public List<FileDB> getAllFiles() {
		    return (List<FileDB>) FR.findAll();
		  }
		
	

}
