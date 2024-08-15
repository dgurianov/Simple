import Tag from '../list-tags/Tag';
import './Commit.css';


const  Commit = ({element}) => {
    return (
        <div className="commit-card" key={element.id}>
            <div className="commit-card-left">
                <label className="commit-card-commit-id">Commit id: {element.commitId}</label>
                <label className="commit-card-memo-tags">{element.memoTags.map((el,index)=>{return <Tag key={index} tagname={el}/>})}</label>
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

