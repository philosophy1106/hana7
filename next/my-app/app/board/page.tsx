import { createPost } from '@/lib/actions';
import FolderDropdown from '@/components/FolderDropdown';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Textarea } from '@/components/ui/textarea';

export default function Board() {
  return (
    <form action={createPost} className='m-3 space-y-3'>
      <div className='flex space-x-2'>
        <FolderDropdown />
        <Input name='title' type='text' placeholder='title...' />
      </div>

      <div>
        <Textarea
          name='content'
          rows={12}
          placeholder='content...'
          className='min-h-32'
        ></Textarea>
      </div>

      <div className='flex justify-around'>
        <Button type='reset'>Cancel</Button>
        <Button variant='destructive'>Remove</Button>
        <Button type='submit' variant='primary'>
          Save
        </Button>
      </div>
    </form>
  );
}
