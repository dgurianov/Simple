import './Commit.css';
import Tag from './Tag';


const  Commit = ({element}) => {
    return (
        <div className="commit-card" key={element.id}>
            <div className="commit-card-left">
            {/* <label>Id: {element.id}</label> */}
            <label className="commit-card-commit-id">Commit id: {element.commitId}</label>
            {/* <label>Username: {element.userName}</label> */}
            {/* <label>Repository Id: {element.repoId}</label> */}
            
            
            <label className="commit-card-memo-tags">{element.memoTags.map((el)=>{return <button type={'submit'}><Tag tagname={el}/></button>})}</label>

            </div>

            <div className="commit-card-right">
            <label className="commit-card-description">Description: {element.description}</label>
            </div>
            <div className='commit-card-buttons'>
                <button type='submit'>  Operation 1</button>
                <button type='submit'>  Operation 2</button>
                <button type='submit'>  Operation 3</button>
            </div>
        </div>

    );
}


export default Commit;

