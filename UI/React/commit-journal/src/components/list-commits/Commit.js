import AxiosClient from '../backend-client/AxiosClient';
import Tag from '../list-tags/Tag';
import './Commit.css';
import { useRecoilState } from 'recoil';
import { commitStateBucket } from '../../state/cjournalState';


const  Commit = ({element,setShowEdit}) => {
    const [commits, setCommitsBucket] = useRecoilState(commitStateBucket);

    const handleDeleteClick= (event) =>{

        const deleteCommitToBackend = async () => {
            try{
                const {data} = await AxiosClient.delete(`/api/v1/commit/${event.target.value}`);
                console.log(data);
            }catch (error){
                console.log(error);
            }
        }
        deleteCommitToBackend();
        setCommitsBucket(commits.filter((commit)=> commit.commitId !== event.target.value));
    }

    const handleEdit =  (event) => {
        console.log("Button triggrered next event:"+event.target);
            setShowEdit(event.target.value);
    }


    return (
        <div className="commit-card" key={element.id}>
            <div className="commit-card-left">
                <label className="commit-card-commit-id">Commit id: {element.commitId}</label>
                <label className="commit-card-memo-tags">{element.tags.map((el)=>{return <Tag key={el.id} tagname={el.id}/>})}</label>
            </div>

            <div className="commit-card-right">
            <label className="commit-card-description">Description: {element.description}</label>
            </div>
            <div className='commit-card-buttons'>
                <button type='submit'>Follow URL</button>
                <button type='submit' value={element.commitId} onClick={handleEdit}>Edit (Not implemented)</button>
                <button onClick={handleDeleteClick} type='submit' value={element.commitId}>Delete</button>
            </div>
        </div>

    );
}

export default Commit;

