package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreatePostServiceTest {
    private PostRepository postRepository;

    private CreatePostService createPostService;

    @BeforeEach
    void setUp() {
        postRepository = mock(PostRepository.class);

        createPostService = new CreatePostService(postRepository);
    }

    @Test
    @DisplayName("게시물 생성")
    void create() {
        PostCreateDto newPost = new PostCreateDto("제목", "작성자", "내용");

        createPostService.createPost(newPost);

        verify(postRepository).save(any(Post.class));
    }
}
