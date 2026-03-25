<template>
  <div v-if="isOpen" class="post-content">
    <PostView
      v-show="!isEdit"
      :post="post"
      @start-edit="startEdit"
      @delete-post="deletePost"
      @close-post="closePost"
    ></PostView>
    <EditPost
      v-show="isEdit"
      :edit-post="editPost"
      @update-post="updatePost"
      @close-post="closePost"
    ></EditPost>
  </div>
</template>

<script setup>
import EditPost from './EditPost.vue';
import PostView from './PostView.vue';
const props = defineProps({
  isOpen: Boolean,
  isEdit: Boolean,
  post: {
    no: [Number, String],
    title: String,
    content: String,
  },
  editPost: {
    no: [Number, String],
    title: String,
    content: String,
  },
});
const emit = defineEmits([
  'start-edit',
  'update-post',
  'delete-post',
  'close-post',
]);

// emit 함수 정의
const startEdit = (post) => {
  emit('start-edit', post);
};
const updatePost = (editPost) => {
  emit('update-post', editPost);
};
const deletePost = (no) => {
  emit('delete-post', no);
};
const closePost = () => {
  emit('close-post');
};
</script>

<style lang="scss" scoped></style>
