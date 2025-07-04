'use server';
export async function createPost(formData: FormData) {
  const title = formData.get('title');
  const content = formData.get('conetent');
  console.log('🚀 ~ createPost ~ title:', title, content);
}
