package com.yom.blinddate.cctv.repository.cctvsourcediff;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yom.blinddate.cctv.dto.CctvSourceDiffSearchParams;
import com.yom.blinddate.cctv.entity.CctvSourceDiff;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

import static com.yom.blinddate.cctv.entity.QCctvSourceDiff.cctvSourceDiff;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Slf4j
@AllArgsConstructor
public class CctvSourceDiffRepositoryImpl implements CctvSourceDiffRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private final JPAQueryFactory queryFactory;
//
//    public CctvSourceDiffRepositoryImpl(JPAQueryFactory queryFactory) {
//        this.queryFactory = new JPAQueryFactory(entityManager);
//    }

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<CctvSourceDiff> searchBy(CctvSourceDiffSearchParams searchParams, PageRequest pageRequest) {
        QueryResults<CctvSourceDiff> result = queryFactory
                .selectFrom(cctvSourceDiff)
                .where(eqResultType(searchParams.getResultType()),
                        eqChangeType(searchParams.getChangeType()),
                        eqUpdId(searchParams.getUpdId()),
                        eqCctvId(searchParams.getCctvId()),
                        eqCctvOfSource(searchParams.getSourceId(), searchParams.getSrcCctvId()),
                        betweenRegDtm(searchParams.getStartDate(), searchParams.getEndDate()))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .fetchResults();

        return new PageImpl<>(result.getResults(), pageRequest, result.getTotal());
    }

    private BooleanExpression eqResultType(Character resultType) {
        if (isNull(resultType)) {
            return null;
        }
        return cctvSourceDiff.resultType.eq(resultType);
    }

    private BooleanExpression eqChangeType(Character changeType) {
        if (isNull(changeType)) {
            return null;
        }
        return cctvSourceDiff.changeType.eq(changeType);
    }

    private BooleanExpression eqUpdId(String updId) {
        if (isEmpty(updId)) {
            return null;
        }
        return cctvSourceDiff.updId.eq(updId);
    }

    private BooleanExpression eqCctvId(String cctvId) {
        if (isEmpty(cctvId)) {
            return null;
        }
        return cctvSourceDiff.cctvId.eq(cctvId);
    }

    private BooleanExpression eqCctvOfSource(String sourceId, Integer srcCctvId) {
        if (isEmpty(sourceId) || isNull(srcCctvId)) {
            return null;
        }
        return cctvSourceDiff.sourceId.eq(sourceId).and(cctvSourceDiff.srcCctvId.eq(srcCctvId));
    }

    // TODO : 조회 가능한 최대 일 수 설정 필요
    private BooleanExpression betweenRegDtm(Date startDate, Date endDate) {
        if (isNull(startDate) || isNull(startDate)) {
            return null;
        }
        return cctvSourceDiff.regDtm.between(startDate, endDate);
    }
}
