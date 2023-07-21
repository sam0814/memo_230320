package com.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.memo.common.FileManagerService;
import com.memo.post.dao.postMapper;
import com.memo.post.domain.Post;

@Service
public class PostBO {
	
	@Autowired
	private postMapper postMapper; // mybatis
	
	@Autowired
	private FileManagerService fileManager;

	//input: userId(글쓴이)
	//output: List<Post>
	public List<Post> getPostListByUserId(int userId) {
		return postMapper.selectPostListByUserId(userId);
	}
	
	public int addPost(int userId, String userLoginId, String subject, String content,
			MultipartFile file) {
		
		// 이미지가 있으면 업로드 후 imagePath 받아옴
		
		String imagePath = null;
		
		// 파일이 업로드가 된 경우 imagePath 받아옴
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		return postMapper.insertPost(userId, subject, content, imagePath);
		
	}
}
