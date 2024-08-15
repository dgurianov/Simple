import { useRecoilValue } from 'recoil';
import './ListOfTags.css';
import Tag from './Tag';
import { tagsStateBucket } from '../../state/cjournalState';


const ListOfTags = () => {
    const tagsBasket = useRecoilValue(tagsStateBucket);
    return(
        <div className='tags-list'>
            {tagsBasket.map((tag,index)=>{
                return(<Tag key={index} tagname={tag}/>);
            })
            }
        </div>
    );
};


export default ListOfTags;