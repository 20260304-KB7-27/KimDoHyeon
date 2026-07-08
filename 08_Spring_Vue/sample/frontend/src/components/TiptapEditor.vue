<script setup>
import { watch } from 'vue';
import { useEditor, EditorContent } from '@tiptap/vue-3';
import StarterKit from '@tiptap/starter-kit';

const props = defineProps({
  modelValue: {
    type: String,
    default: '',
  },
});

const emit = defineEmits(['update:modelValue']);

const editor = useEditor({
  content: props.modelValue,
  extensions: [StarterKit],
  onUpdate: ({ editor }) => {
    emit('update:modelValue', editor.getHTML());
  },
});

watch(
  () => props.modelValue,
  (value) => {
    if (!editor.value) return;

    if (value !== editor.value.getHTML()) {
      editor.value.commands.setContent(value, false);
    }
  },
);
</script>

<template>
  <div class="editor">
    <EditorContent :editor="editor" />
  </div>
</template>

<style scoped>
.editor {
  border: 1px solid #ced4da;
  border-radius: 6px;
}

:deep(.ProseMirror) {
  min-height: 300px;
  padding: 12px;
  outline: none;
}
</style>
